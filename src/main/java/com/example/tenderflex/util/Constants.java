package com.example.tenderflex.util;

public class Constants {
    public static String SECRET = "SecretForTenderFlex";
    public static String LOGIN_URL = "/login";
    public static String ROLE_BIDDER = "ROLE_BIDDER";
    public static String ROLE_CONTRACTOR = "ROLE_CONTRACTOR";
    public static String ROLE_FOR_CLOSED_ENDPOINT = "CLOSED_FOR_NOW";
    public static Long OFFER_STATUS_SENT_ID = 1L;
    public static int OFFER_STATUS_AWARDED_CONTRACTOR_ID = 2;
    public static int OFFER_STATUS_APPROVED_BIDDER_ID = 3;
    public static int OFFER_STATUS_DECLINED_BIDDER_ID = 4;
    public static int OFFER_STATUS_DECLINED_CONTRACTOR_ID = 5;
    public static String FILES_REPOSITORY_HOME = "src/main/resources/filerepository";
}
