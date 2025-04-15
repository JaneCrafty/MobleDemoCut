#!/bin/bash

date
DBRANCHNAME=${branchName:-${stackName}}
echo "stageName=${DBRANCHNAME}"

${ALLURECTL_PATH} job-run plan --output-file ${ALLURE_TESTPLAN_PATH}
${ALLURECTL_PATH} watch --results target/allure-results -- timeout 27000 \
  mvn ${MVN_OPTS} clean test \
    -DappBranchName=https://${DBRANCHNAME}.example.com \
    -DthreadCount=${THREAD_COUNT} \
    -DrunSuite=${TEST_SUITE}.class \
    -DappiumPort=${APPIUM_PORT} \
    -DappBranch=${appBranch} \
    -DappName=${appName} \
    -DconfigFile=${configFile} \
    -Djob_id=${CI_JOB_ID} \
    -Dparent_job_id=${callerJobId} \
    -Dversion_number=${VERSION_NUMBER} \
    -Dcode_number=${VERSION_CODE} \
    -Dautotests_job_url=${CI_JOB_URL} \
    -DjiraPassword=${JIRA_QA_PASSWORD} \
    -Dslack_token=${SLACK_TOKEN} \
    -Dplatform_name=${PLATFORM_NAME} \
    -Dsumsub_app_token=${SUMSUB_APP_TOKEN} \
    -Dsumsub_secret_key=${SUMSUB_SECRET_KEY} \
    -Dsumsub_test_base_url=${SUMSUB_TEST_BASE_URL} \
    -Dallure_launch_name=${ALLURE_LAUNCH_NAME} \
    -DcashierChanges=${cashierChanges} \
    -Dgitlab_user_email=${GITLAB_USER_EMAIL}