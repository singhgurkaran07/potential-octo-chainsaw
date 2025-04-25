package basics;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ToString
public final class SampleImmutable {

    //Immutable objects are inherently thread-safe as their state cannot change after construction.

    @Getter
    private final String name;
    @Getter
    private final Integer age;
    private final List<String> hobbies; // Mutable field example


    public SampleImmutable(String name, Integer age, List<String> hobbies){
        this.name = name;
        this.age = age;
        // Create a defensive copy of the mutable list
        this.hobbies = hobbies != null ? new ArrayList<>(hobbies) : Collections.emptyList();
    }

    public List<String> getHobbies() {
        // Return an unmodifiable view of the list to ensure immutability
        return Collections.unmodifiableList(hobbies);
    }

    //No setters for modification


    /*
    * Why final is Not Enough for a List:
        The final keyword ensures:

        You cannot do something like this.hobbies = new ArrayList<>() after the object is constructed.

        It does not protect the internal state of the List.

        Since List is mutable, anyone with a reference to it can add, remove, or modify its elements.
        To ensure true immutability, we need to:

            Create a defensive copy of the input list in the constructor.

            Return an unmodifiable view (e.g., using Collections.unmodifiableList) when accessing the list.


    *
    * */
}
