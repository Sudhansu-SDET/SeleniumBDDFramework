package com.Pages;

public class LoginPage {

    public static String getEMAIL() {
        return EMAIL;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static String getSignIn() {
        return SignIn;
    }

    public static String getOrderHistoryAndDetails() {
        return ORDER_HISTORY_AND_DETAILS;
    }

    public static String getMyWishlists() {
        return MY_WISHLISTS;
    }

    public static String EMAIL = "input[id='email']";
    public static String PASSWORD = "input[id='passwd']";
    public static String SignIn = "button[id='SubmitLogin']";




    public static String ORDER_HISTORY_AND_DETAILS ="a[title='Orders']";
    public static String MY_WISHLISTS ="a[title='My wishlists']";


}
