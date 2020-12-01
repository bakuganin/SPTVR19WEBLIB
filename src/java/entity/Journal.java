/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author user
 */
@Entity
public class Journal implements Serializable {
        @Id
        private Person student;
        private Book subject;
        private Integer mark;
        private Date date;

    public Journal(Person person, Book subject, Integer mark, Date date) {
        this.student = person;
        this.subject = subject;
        this.mark = mark;
        this.date = date;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.YYYY hh:mm");
        String dateStr = sdf.format(date);
        return "Journal{"   + "student FirstName=" + student.getFirstName()
                            +"student LastName=" + student.getLastName()
                            + ", subject=" + subject.getName()
                            + ", mark=" + mark
                            + ", date=" + dateStr + '}';
    }
    
    public Journal() {
    }

   

    public Book getSubject() {
        return subject;
    }

    public void setSubject(Book subject) {
        this.subject = subject;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Person getStudent() {
        return student;
    }

    public void setStudent(Person student) {
        this.student = student;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.student);
        hash = 23 * hash + Objects.hashCode(this.subject);
        hash = 23 * hash + Objects.hashCode(this.mark);
        hash = 23 * hash + Objects.hashCode(this.date);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Journal other = (Journal) obj;
        if (!Objects.equals(this.student, other.student)) {
            return false;
        }
        if (!Objects.equals(this.subject, other.subject)) {
            return false;
        }
        if (!Objects.equals(this.mark, other.mark)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }

    public void getByStudent(Person person, List<Journal> listJournals) {
        System.out.println("Оценки: " );
        for(int i = 0; i < listJournals.size(); i++){
                    //System.out.println(person);
                    //System.out.println(listJournals.get(i).getStudent());
                    if(person.equals(listJournals.get(i).getStudent())){
                        System.out.println(listJournals.get(i).getMark() + " по предмету: " + listJournals.get(i).getSubject().getName());
                }
        }}
    
    public void getBySubject(Book subject, List<Journal> listJournals) {
        System.out.println("Оценки: " );
        for(int i = 0; i < listJournals.size(); i++){
                    if(subject.equals(listJournals.get(i).getSubject())){
                        System.out.println(listJournals.get(i).getDate() + " \n" + listJournals.get(i).getMark() + " по ученика: " + listJournals.get(i).getStudent().getFirstName());
                }
        }}

    public void getChangeMark(Person person, List<Journal> listJournals) {
        System.out.println("Оценки: " );
        for(int i = 0; i < listJournals.size(); i++){
                    if(person.equals(listJournals.get(i).getStudent())){
                        System.out.println( i + " " + listJournals.get(i).getMark() + " по предмету: " + listJournals.get(i).getSubject().getName());
                }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите какую оценку исправить: " );
        int index = scanner.nextInt();
        System.out.println("Какую оценку поставить: " );
        int mark = scanner.nextInt();
        listJournals.get(index).setMark(mark);
        }}
    }
    

