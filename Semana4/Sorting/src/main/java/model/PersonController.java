package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PersonController {

    private ArrayList<Person> people;

    public PersonController(){
        people = new ArrayList<>();
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public ArrayList<Person> selectionSort(ArrayList<Person> toSort, Comparator<Person> comparator){
        int n = toSort.size();

        for(int i=0; i< n-1; i++){
            for (int j = i+1; j < n; j++) {
                if(comparator.compare(toSort.get(i), toSort.get(j)) > 0){
                    Person prev = toSort.get(i);
                    Person current = toSort.get(j);

                    toSort.set(i, current);
                    toSort.set(j, prev);
                }
            }
        }
        return toSort;
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


    public Person binarySearch(ArrayList<Person> toSearch, String name, Comparator<String> comparator){

        Person found = null;

        int start = 0;
        int end = toSearch.size() -1;
        int mid = (start + end)/2;

        while(found == null && start <= end){

            // 1. CASO BASE = El elemento buscado esta en el centro.
            if ( comparator.compare(toSearch.get(mid).getName(), name) == 0){
                found = toSearch.get(mid);
            }

            // 2. CASO BASE = El elemento buscado es mayor que el elemento del centro
            else if( toSearch.get(mid).getName().compareTo(name) < 0){
                start = mid+1;
            }

            // 3. CASO BASE = El elemento buscado es menor que el elemento del centro
            else if(toSearch.get(mid).getName().compareTo(name) > 0){
                end = mid-1;
            }

            mid = (start + end)/2;
        }

        return found;
    }

    public Person binarySearch(ArrayList<Person> toSearch, String name){

        Person found = null;

        int start = 0;
        int end = toSearch.size() -1;
        int mid = (start + end)/2;

        while(found == null && start <= end){

            // 1. CASO BASE = El elemento buscado esta en el centro.
            if (toSearch.get(mid).getName().compareTo(name) == 0){
                found = toSearch.get(mid);
            }

            // 2. CASO BASE = El elemento buscado es mayor que el elemento del centro
            else if( toSearch.get(mid).getName().compareTo(name) < 0){
                start = mid+1;
            }

            // 3. CASO BASE = El elemento buscado es menor que el elemento del centro
            else if(toSearch.get(mid).getName().compareTo(name) > 0){
                end = mid-1;
            }

            mid = (start + end)/2;
        }

        return found;
    }

}
