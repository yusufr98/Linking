package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    private static ArrayList<Company> companies = new ArrayList<>();
    private static ArrayList<Person> people = new ArrayList<>();
    private static ArrayList<Link> links = new ArrayList<>();
    private static Scanner k = new Scanner(System.in);
    public static void main(String[] args) {
	    Company apple = new Company(0,"Apple");
	    Company facebook = new Company(1,"Facebook");
	    Company tesla = new Company(2,"Tesla");
        Collections.addAll(companies, apple, facebook, tesla);
	    Person steve = new Person("Steve Jobs", 0);
	    Person tim = new Person("Tim Cook", 1);
	    Person jony = new Person("Jony Ive", 2);
	    Person mark = new Person("Mark Zuckerburg", 3);
	    Person elon = new Person("Elon Musk",4);
	    Collections.addAll(people, steve, tim, jony, mark, elon);
	    Link link = new Link(apple.getId(), steve.getId(), 0);
	    Link link1 = new Link(apple.getId(), tim.getId(), 1);
	    Link link2 = new Link(apple.getId(), jony.getId(), 2);
	    Link link3 = new Link(facebook.getId(), mark.getId(), 3);
	    Link link4 = new Link(tesla.getId(), elon.getId(), 4);
        Collections.addAll(links, link, link1, link2, link3, link4);
        display();
        boolean repeat =true;
        String choice;
        do {
            System.out.print("What would you like to do(add/edit/quit)?");
            choice = k.nextLine();
            if (choice.equalsIgnoreCase("add")) {
                add();
            }
            else if(choice.equalsIgnoreCase("edit")){
                edit();
            }
            else{
                if(!choice.equalsIgnoreCase("quit")){
                    System.out.print("Invalid Choice!");
                }
            }
        } while(!choice.equalsIgnoreCase("quit"));
        display();
    }
    public static int lookForCompany(){
        boolean bool = true;
        long id = 0;
        do {
            System.out.print("Which company name will you be changing?");
            String cn = k.nextLine();
            for (Company company : companies) {
                if (cn.equalsIgnoreCase(company.getName())) {
                    bool = false;
                    id = company.getId();
                }
            }
            if (bool) {
                System.out.println("No such company exists.");
            }
        } while(bool);
        return (int)id;
    }
    public static int lookForPerson(){
        boolean bool = true;
        long id = 0;
        do {
            System.out.print("Which person name will you be changing?");
            String cn = k.nextLine();
            for (Person person: people) {
                if (cn.equalsIgnoreCase(person.getName())) {
                    bool = false;
                    id = person.getId();
                }
            }
            if (bool) {
                System.out.println("No such person exists.");
            }
        } while(bool);
        return (int)id;
    }
    public static void edit(){
        System.out.print("Would you like to edit a company or a person?");
        String c = k.nextLine();
        if(c.equalsIgnoreCase("company")){
            int i = lookForCompany();
            System.out.print("Enter new name: ");
            String n = k.nextLine();
            companies.get(i).setName(n);
        }
        else if(c.equalsIgnoreCase("person")){
            int i = lookForPerson();
            System.out.print("Enter new name: ");
            String n = k.nextLine();
            people.get(i).setName(n);
        }
    }
    public static void add(){
        System.out.print("Would you like to add a company, person, or a link?");
        String c = k.nextLine();
        if(c.equalsIgnoreCase("company")){
            System.out.print("What is the name of the company?");
            String cn = k.nextLine();
            companies.add(new Company(companies.size(), cn));
        }
        else if(c.equalsIgnoreCase("person")){
            System.out.print("What is the name of the person?");
            String cn = k.nextLine();
            people.add(new Person(cn, people.size()));
        }
        else if(c.equalsIgnoreCase("link")){
            boolean bool = true;
            long cid=0, pid=0;
            do {
                System.out.print("Which company are you linking?");
                String s = k.nextLine();
                for(Company company: companies){
                    if(s.equalsIgnoreCase(company.getName())){
                        bool = false;
                        cid = company.getId();
                    }
                }
                if(bool){
                    System.out.println("No such company exists.");
                }
            } while(bool);
            bool = true;
            do{
                System.out.print("Which person are you linking to this company?");
                String name = k.nextLine();
                for(Person person: people){
                    if(name.equalsIgnoreCase(person.getName())){
                        bool = false;
                        pid = person.getId();
                    }
                }
                if(bool){
                    System.out.println("No such person exists.");
                }
            } while (bool);
            links.add(new Link(cid, pid, links.size()));
        }
    }
    public static void display(){
        for(Person p : people){
            for(Link l : links){
                if(l.getPersonId() == p.getId()){
                    for(Company c: companies){
                        if(c.getId() == l.getCompId()){
                            System.out.println(p.getName() + ", " + c.getName());
                        }
                    }
                }
            }
        }
    }
}
