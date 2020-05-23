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
       return profiles.stream().map(profile -> profile.address).collect(Collectors.toList());
   }
    @Override
    public String toString() {
        return  address + "";
    }
}
