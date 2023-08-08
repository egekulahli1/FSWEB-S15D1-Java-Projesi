package com.workintech.w3d1.model;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public boolean addNewContact(Contact contact) {
        if (findContact(contact) >= 0) {
            System.out.println("Contact already exists.");
            return false;
        }

        myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int index = findContact(oldContact);
        if (index < 0) {
            System.out.println("Contact not found.");
            return false;
        }

        myContacts.set(index, newContact);
        return true;
    }

    public boolean removeContact(Contact contact) {
        int index = findContact(contact);
        if (index < 0) {
            System.out.println("Contact not found.");
            return false;
        }

        myContacts.remove(index);
        return true;
    }

    private int findContact(Contact contact) {
        return myContacts.indexOf(contact);
    }

    private int findContact(String name) {
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact = myContacts.get(i);
            if (contact.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String name) {
        int index = findContact(name);
        if (index >= 0) {
            return myContacts.get(index);
        }
        return null;
    }

    public void printContacts() {
        System.out.println("Contact List:");
        for (int i = 0; i < myContacts.size(); i++) {
            System.out.println((i + 1) + ". " + myContacts.get(i).getName() + " -> " + myContacts.get(i).getPhoneNumber());
        }
    }
}

