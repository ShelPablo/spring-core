package com.andreitop.xml.config;

import com.andreitop.xml.mount.Mount;
import com.andreitop.xml.mount.Tiger;
import com.andreitop.xml.mount.Wolf;
import com.andreitop.xml.unit.Human;
import com.andreitop.xml.unit.Orc;
import com.andreitop.xml.unit.Troll;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.*;

import static com.andreitop.xml.unit.Troll.DEFAULT_MOUNT;
import static java.util.concurrent.ThreadLocalRandom.*;

@Configuration
public class AppConfig {

    @Bean("shadowTiger")
    public Mount newTiger() {
        return new Tiger();
    }

    @Bean("frostWolf")
    public Mount newWolf() {
        return new Wolf();
    }

    @Bean("knight")
    public Human newHuman() {
        return new Human(newTiger(), "thunderFury","soulBlade");
    }

    @Bean("trall")
    public Orc newOrc() {
        return new Orc (newWolf())
                .setWeapon("furryAxe")
                .setColorCode(9);
    }

    @Bean("zulJin")
    public Troll newTroll() {
        return  new Troll()
                .setColorCode(trollColorCode())
                .setCreationDate(new Date("02/29/2004"));
    }

    @Bean("colorCode")
    public int trollColorCode() {
        return current().nextInt(2,10);
    }

    @Bean("troll'sMountsList")
    public List<Mount> trollMountList() {
        List<Mount> list = new ArrayList<>();
        list.add(DEFAULT_MOUNT);
        list.add(null);
        list.add(newTiger());
        return list;
    }

    @Bean("troll'sMountsSet")
    public Set<Mount> trollMountSet() {
        Set<Mount> set = new LinkedHashSet<>();
        set.add(newTiger());
        set.add(newWolf());
        return set;
    }

    @Bean("troll'sMountsMap")
    public Map<String, Mount> trollMountMap() {
        Map<String, Mount> map = new HashMap<>();
        map.put("m1", newWolf());
        map.put("m2", newTiger());
        return map;
    }


}
