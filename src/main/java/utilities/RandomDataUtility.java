package utilities;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;

import java.util.Random;

public class RandomDataUtility {

    public static Faker faker;
    public static Random random;

    public static String getRandomFirstName(){

        faker=new Faker();
        String firstName=faker.name().firstName();
        return firstName;
    }
    public static String getRandomLastName(){

        faker=new Faker();
        String lastName=faker.name().lastName();
        return lastName;
    }
    public static PhoneNumber getRandomPhoneNumber(){

        faker=new Faker();
        PhoneNumber phoneNumber=faker.phoneNumber();
        return phoneNumber;
    }
    public static Address getRandomAddress(){

        faker=new Faker();
        Address address=faker.address();
        return address;
    }

    public static String getRandomEmail(){
        String alphabet="abcdefghijklmnopqrstuvwxyz";
        random=new Random();
        StringBuilder sb=new StringBuilder();
        int length=5;
        for(int i=0;i<length;i++){
            int randomNumber=random.nextInt(alphabet.length());
            int randomChar=alphabet.charAt(randomNumber);
            sb.append(randomChar);
        }
        String email=sb.toString()+"@abc.com";
        return email;

    }

}
