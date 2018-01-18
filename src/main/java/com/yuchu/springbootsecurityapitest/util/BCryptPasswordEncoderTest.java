package com.yuchu.springbootsecurityapitest.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: luqinglin
 * Date: 2018-01-18
 * Time: 13:36
 */
public class BCryptPasswordEncoderTest {
    /*public static void main(String[] args) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println("encoder:  " + encoder.encode("abel"));
        System.out.println("encoder:  " + encoder.encode("admin"));

        if (encoder.matches("abel", "$2a$10$IAz6WzJ314LH1NXq7Rf.dOYPP2uvzk08g.eAl9l4DRG4YsxavEV4W")) {
            System.out.println("encoder: true");
        }


        System.out.println("------------华丽的分割线-----------------------");
        String Md5Password = MD5Util.encode("abel");
        System.out.println("Md5Password:  " + Md5Password);
        System.out.println("encoder:  " + encoder.encode(Md5Password));
        if (encoder.matches(Md5Password, "$2a$10$XUwVzOZpZf6wSS7Kmg/tQ.L0b68J/RwP3EMFon2Dc5HD0u1ACLYE6")) {
            System.out.println("Md5Password: true");
        }
//        System.out.println("------------华丽的分割线-----------------------");
//        String Md5Password2 = MD5Util.encode("admin");
//        System.out.println("Md5Password2:  " + Md5Password2);
//        System.out.println("encoder:  " + encoder.encode("admin:"+Md5Password2));
//        if (encoder.matches(Md5Password2, "$2a$10$SUfvX3qymIvXbVq3pqku9O6QD6kTPFA9mjqnwk78.mCu0sSclVjgC")) {
//            System.out.println("Md5Password: true");
//        }

    }*/
}
