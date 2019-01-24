//package com.libraryapp.security;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//public class LoggedUserUtils {
//
//
//
//
//        public static Long loggedUserId() {
//            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//            Object principal = authentication.getPrincipal();
//            if (principal instanceof UserDetailsImplementation) {
//                UserDetailsImplementation loggedUser = (UserDetailsImplementation)principal;
//                return loggedUser.getId();
//            } else {
//                throw new RuntimeException();
//            }
//        }
//
//        public static boolean isLoggedUserIsAdmin() {
//            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//            Object principal = authentication.getPrincipal();
//            if (principal instanceof UserDetailsImplementation) {
//                UserDetailsImplementation loggedUser = (UserDetailsImplementation)principal;
//                return loggedUser.isAdmin();
//            } else {
//                throw new RuntimeException();
//            }
//
//            //useless bo nie mam roli admin
//        }
//}
