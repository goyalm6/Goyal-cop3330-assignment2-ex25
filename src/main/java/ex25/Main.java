/*
 *  UCF COP3330 Fall 2021 Assignment 1 Solution, Exercise 25
 *  Copyright 2021 Mayank Goyal
 */

package ex25;

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main
{
    static Boolean onlyNumbers(String str, int len)
    {
        for (int i = 0; i < len; i++)
        {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9')
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        return false;
    }

    static Boolean hasSpecialChar(String pwd)
    {
        Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
        Matcher hasSpecial = special.matcher(pwd);
        if (hasSpecial.find())
        {
            return true;
        }
        return false;
    }

    static String passwordValidator(String pwd)
    {
        int len = pwd.length();
        boolean onlyLetters = pwd.matches("[a-zA-Z]+");
        if(len < 8)
        {
            if(onlyNumbers(pwd, len))
            {
                return "very weak";
            }
            else if(onlyLetters)
            {
                return "weak";
            }
        }
        else if(len >= 8)
        {
            Pattern letter = Pattern.compile("[a-zA-z]");
            Pattern digit = Pattern.compile("[0-9]");
            Matcher hasLetter = letter.matcher(pwd);
            Matcher hasDigit = digit.matcher(pwd);
            if(hasDigit.find() && hasLetter.find() && hasSpecialChar(pwd))
            {
                return "very strong";
            }
            else if(hasDigit.find() && hasLetter.find())
            {
                return "strong";
            }
        }
        return "";
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please provide the password: ");
        String pwd = scanner.nextLine();
        String pwdStatus = passwordValidator(pwd);
        if(pwdStatus != "")
        {
            System.out.print("The password " + pwd + " is a " + pwdStatus + " password.");
        }
    }
}
