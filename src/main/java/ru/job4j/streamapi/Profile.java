package ru.job4j.streamapi;

import java.util.List;
import java.util.stream.Collectors;

public class Profile {
    private Address address;

    public Profile() {

    }

    public Profile(Address address) {
        this.address = address;
    }
   public List<Address> collect(List<Profile> profiles) {
       System.out.println(profiles);
       return profiles.stream().map(profile -> profile.address).collect(Collectors.toList());
   }

    public static void main(String[] args) {
        Profile profile = new Profile(new Address("Dnipro", "Grushevsky", 11, 108));
        List<Profile> list = List.of(profile);
        profile.collect(list);
    }

    @Override
    public String toString() {
        return  address + "";
    }
}
