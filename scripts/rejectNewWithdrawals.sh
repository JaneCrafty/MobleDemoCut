#!/bin/bash

echo "Starting reject withdrawals"
UserEmail="autotestUser1@gmail.com"
UserPassword="autotestUser1@gmail.com"

UserAuthtoken=$(curl 'https://api.autotest.example.com/passport/v2/sign_in?locale=en' \
  -H 'device-id: feb941d06be30cd157ea433d2a216c75' \
  -H 'device-type: web' \
  -H 'content-type: application/json' \
  --data '{"email":"'$UserEmail'","password":"'$UserPassword'"}' | grep -Eo "\w+-\w+-\w+-\w+-\w+")
echo $UserAuthtoken

NewWithdrawalTransactions=$(curl 'https://api.autotest.example.com/platform/private/transactions?per=50&status=pending&type=withdraw&locale=en' \
  -H 'device-id: feb941d06be30cd157ea433d2a216c75' \
  -H 'device-type: web' \
  -H 'content-type: application/json' \
  -H 'authorization-token: '"$UserAuthtoken" \
  | grep -Eo "\w+-\w+-\w+")
echo $NewWithdrawalTransactions

CrmAuthtoken=$(curl --request POST 'https://crm.autotest.example.com/api/v1/sign_in?email=admin@example.loc&password=qwe123' \
  | grep -Eo "[-_[:alnum:]]+\.[-_[:alnum:]]+\.[-_[:alnum:]]+")
echo $CrmAuthtoken

for transactionId in $NewWithdrawalTransactions
do
  echo "Reject transaction with id "$transactionId
  curl 'https://crm.autotest.example.com/orders/'"$transactionId" \
    -H 'content-type: application/x-www-form-urlencoded; charset=UTF-8' \
    -H 'cookie: crm_authz_token='"$CrmAuthtoken" \
    --data 'utf8=%E2%9C%93&_method=patch&_action=reject&_delay=0&reason=no_reason&comment=Autotests+reject+transactions&manual_provider=manual_pay&delayed_to='
done