package com.example.manager_house_88.utils;

import java.security.Principal;

/**
 * Created by cx on 18-1-5.
 */
public class PrincipalUtil {

        public static String getOpenid(Principal principal){

            return principal.getName();
        }

}
