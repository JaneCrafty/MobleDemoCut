package com.example.JMobile.framework.DataProviders;

import com.example.JMobile.framework.Helpers.StringHelper;

// todo: refactor to enum UserProfile
public class UserData {
    private static final String _email = "autotestUser1@gmail.com";
    private static final String _password = "autotestUser1@gmail.com";
    private static final String _email2 = "autotestUser2@gmail.com";
    private static final String _password2 = "autotestUser2@gmail.com";
    private static final String _email3 = "autotestUser3@gmail.com";
    private static final String _password3 = "autotestUser3@gmail.com";
    private static final String _email4 = "autotestUser4@gmail.com";
    private static final String _password4 = "autotestUser4@gmail.com";
    private static final String _email5 = "autotestUser5@gmail.com";
    private static final String _password5 = "autotestUser5@gmail.com";
    private static final String _email6 = "autotestUser6@gmail.com";
    private static final String _password6 = "autotestUser6@gmail.com";
    private static final String _email7 = "autotestUser7@gmail.com";
    private static final String _password7 = "autotestUser7@gmail.com";
    private static final String _email8 = "autotestUser8@gmail.com";
    private static final String _password8 = "autotestUser8@gmail.com";
    private static final String _emailStandard = "dontTouchAutotestStandardUser1@gmail.com";
    private static final String _passwordStandard = "dontTouchAutotestStandardUser1@gmail.com";
    private static final String _emailCfdDemoBalanceUser = "DontTouchAutoTestDemoBalanceUser@example.com";
    private static final String _passwordCfdDemoBalanceUser = "DontTouchAutoTestDemoBalanceUser@example.com1";
    private static final String _emailFttDemoBalanceUser = "DontTouchAutoTestDemoBalanceUser2@example.com";
    private static final String _passwordFttDemoBalanceUser = "DontTouchAutoTestDemoBalanceUser2@example.com";
    private static final String _emailGold = "DontTouchAutoTestGoldBalanceUser1@gmail.com";
    private static final String _passwordGold = "DontTouchAutoTestGoldBalanceUser1@gmail.com";
    private static final String _freeUserEmailFromUA = "DontTouchAutotestFreeUser0FromUA@ya.ru";
    private static final String _freeUserPasswordFromUA = "DontTouchAutotestFreeUser0FromUA@ya.ru";
    private static final String _standardUserEmailFromUA = "DontTouchAutotestStandardUser0FromUA@ya.ru";
    private static final String _standardUserPasswordFromUA = "DontTouchAutotestStandardUser0FromUA@ya.ru";
    // Do not change transactions without the approval of the JBIN!!!
    private static final String _pendingTransactionsUserEmail = "processingtransactionhistory@gmail.com";
    private static final String _pendingTransactionsUserPassword = "qwerty123";
    //
    // Do not change transactions without the approval of the JBIN!!!
    private static final String _doneVerificationUserEmail = "donesumsub@gmail.com";
    private static final String _doneVerificationUserPassword = "qwerty123";
    //
    private static final String _rejectTransactionsUserEmail = "rejectTransactionsUser0@ya.ru";
    private static final String _rejectTransactionsUserPassword = "rejectTransactionsUser0@ya.ru";
    private static final String _errorTransactionsUserEmail = "errorTransactionsUser0@ya.ru";
    private static final String _errorTransactionsUserPassword = "errorTransactionsUser0@ya.ru";
    private static final String _userTournamentCertificateEmail = "UserTournamentCertificate@ya.ru";
    private static final String _userTournamentCertificatePassword = "QWErty123!";
    private static final String _userTournamentCertificate2Email = "UserTournamentCertificate2@ya.ru";
    private static final String _userTournamentCertificate2Password = "QWErty123!";

    private static final String _moderatorUserEmail = "automodertests@yahoo.com";
    private static final String _moderatorUserPassword = "7kX9wy6DebkOB";

    public static final String crmAdminEmail = "admin@example.loc";
    public static final String crmAdminPassword = "qwe123";

    public static String getModeratorUserEmail() {
        return _moderatorUserEmail;
    }

    public static String getModeratorUserPassword() {
        return _moderatorUserPassword;
    }

    public static String getEmailNewUser() {
        return StringHelper.GetRandomEmail("example.com");
    }

    public static String getAutotestUser1Email() {
        return _email;
    }

    public static String getAutotestUser1Password() {
        return _password;
    }

    public static String getAutotestUser2Email() {
        return _email2;
    }

    public static String getAutotestUser2Password() {
        return _password2;
    }

    public static String getAutotestUser3Email() {
        return _email3;
    }

    public static String getAutotestUser3Password() {
        return _password3;
    }

    public static String getAutotestUser4Email() {
        return _email4;
    }

    public static String getAutotestUser4Password() {
        return _password4;
    }

    public static String getAutotestUser5Email() {
        return _email5;
    }

    public static String getAutotestUser5Password() {
        return _password5;
    }

    public static String getAutotestUser6Email() {
        return _email6;
    }

    public static String getAutotestUser6Password() {
        return _password6;
    }

    public static String getAutotestUser7Email() {
        return _email7;
    }

    public static String getAutotestUser7Password() {
        return _password7;
    }

    public static String getAutotestUser8Email() {
        return _email8;
    }

    public static String getAutotestUser8Password() {
        return _password8;
    }

    public static String getCfdDemoBalanceUserEmail() {
        return _emailCfdDemoBalanceUser;
    }

    public static String getFttDemoBalanceUserEmail() {
        return _emailFttDemoBalanceUser;
    }

    public static String getCfdDemoBalanceUserPassword() {
        return _passwordCfdDemoBalanceUser;
    }

    public static String getFttDemoBalanceUserPassword() {
        return _passwordFttDemoBalanceUser;
    }

    public static String getStandardUserEmail() {
        return _emailStandard;
    }

    public static String getStandardUserPassword() {
        return _passwordStandard;
    }

    public static String getGoldUserEmail() {
        return _emailGold;
    }

    public static String getGoldUserPassword() {
        return _passwordGold;
    }

    public static String getFreeUserEmailFromUA() {
        return _freeUserEmailFromUA;
    }

    public static String getFreeUserPasswordFromUA() {
        return _freeUserPasswordFromUA;
    }

    public static String getStandardUserEmailFromUA() {
        return _standardUserEmailFromUA;
    }

    public static String getStandardUserPasswordFromUA() {
        return _standardUserPasswordFromUA;
    }

    public static String getPendingTransactionsUserEmail() {
        return _pendingTransactionsUserEmail;
    }

    public static String getPendingTransactionsUserPassword() {
        return _pendingTransactionsUserPassword;
    }

    public static String getDoneVerificationUserEmail() {
        return _doneVerificationUserEmail;
    }

    public static String getDoneVerificationUserPassword() {
        return _doneVerificationUserPassword;
    }

    public static String getRejectTransactionsUserEmail() {
        return _rejectTransactionsUserEmail;
    }

    public static String getRejectTransactionsUserPassword() {
        return _rejectTransactionsUserPassword;
    }

    public static String getErrorTransactionsUserEmail() {
        return _errorTransactionsUserEmail;
    }

    public static String getErrorTransactionsUserPassword() {
        return _errorTransactionsUserPassword;
    }

    public static String getUserTournamentCertificateEmail() {
        return _userTournamentCertificateEmail;
    }

    public static String getUserTournamentCertificatePassword() {
        return _userTournamentCertificatePassword;
    }

    public static String getUserTournamentCertificate2Email() {
        return _userTournamentCertificate2Email;
    }

    public static String getUserTournamentCertificate2Password() {
        return _userTournamentCertificate2Password;
    }

    public static String getEmailWithdrawalUser() {
        return "WithdrawalUserQA@example.com";
    }

    public static String getUsername() {
        return StringHelper.GetRandomName();
    }

    public static String getSurname() {
        return StringHelper.GetRandomSurname();
    }

    public static String getPhone() {
        return StringHelper.GetRandomSurname();
    }
}

