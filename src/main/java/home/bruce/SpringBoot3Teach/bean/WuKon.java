package home.bruce.SpringBoot3Teach.bean;

//import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

//@JacksonXmlRootElement
@Getter
@Setter
public class WuKon {
    private int id;
    private String name;

    private Date dateTime;
    private LocalDateTime dateTime2;
    private int[] iArray;
    private List<String> ls;
    private Set<String> set;
    private List<Dog> dogs;
    private Map<String, Dog> dogMap;

}
