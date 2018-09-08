package com.andreitop.xml.unit;

import com.andreitop.xml.mount.Mount;
import com.andreitop.xml.mount.Wolf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.*;
import java.util.stream.Stream;


public class Troll implements Unit {
    private List<Mount> listOfMounts;
    private Set<Mount> setOfMounts;
    private Map<String, Mount> mapOfMounts;
    private Date creationDate;
    public static final Mount DEFAULT_MOUNT = new Wolf();
    private int colorCode;

    public int getColorCode() {
        return colorCode;
    }

    public Troll setColorCode(int colorCode) {  this.colorCode = colorCode; return this;  }

    public Date getCreationDate() {
        return creationDate;
    }

    public Troll setCreationDate(Date creationDate) {
        this.creationDate = creationDate; return this;
    }

    @Autowired
    @Qualifier("troll'sMountsList")
    public void setListOfMounts(List<Mount> listOfMounts) {
        this.listOfMounts = listOfMounts;
    }
    @Autowired
    @Qualifier("troll'sMountsSet")
    public void setSetOfMounts(Set<Mount> setOfMounts) {
        this.setOfMounts = setOfMounts;
    }
    @Autowired
    @Qualifier("troll'sMountsMap")
    public void setMapOfMounts(Map<String, Mount> mapOfMounts) {
        this.mapOfMounts = mapOfMounts;
    }

    public List<Mount> getListOfMounts() {
        return listOfMounts;
    }

    public Set<Mount> getSetOfMounts() {
        return setOfMounts;
    }

    public Map<String, Mount> getMapOfMounts() {
        return mapOfMounts;
    }

    @Override
    public void mountMove() {
        mapOfMounts.forEach((k, v) -> {
            System.out.print("key=" + k + " ");
            v.move();
        });
        Stream.of(listOfMounts,setOfMounts)
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .forEach(Mount::move);

    }
}
