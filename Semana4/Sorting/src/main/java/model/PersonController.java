package model;

import java.util.ArrayList;
import java.util.List;

public class PersonController {

    private ArrayList<Person> people;

    public PersonController(){
        people = new ArrayList<>();
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public ArrayList<Person> selectionSort(ArrayList<Person> toSort){
        int n = toSort.size();

        for(int i=0; i< n-1; i++){
            for (int j = i+1; j < n; j++) {
                if(toSort.get(i).compareTo(toSort.get(j)) > 0){
                    Person prev = toSort.get(i);
                    Person current = toSort.get(j);

                    toSort.set(i, current);
                    toSort.set(j, prev);
                }
            }
        }
        return toSort;
    }

    public ArrayList<Person> insertionSort(ArrayList<Person> toSort){
        int n = toSort.size();

        for (int i = 1; i < n; i++) {
            Person current = toSort.get(i);
            int j = i - 1;

            while (j >= 0 && current.compareTo(toSort.get(j)) < 0 ){
                toSort.set(j+1, toSort.get(j));
                --j;
            }
            toSort.set(j+1, current);
        }
        return toSort;
    }

}
