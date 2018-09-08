package com.andreitop.xml.unit;

import com.andreitop.xml.mount.Mount;

public class Orc implements Unit {

    private Mount mount;
    private String weapon;
    private int colorCode;

    public Orc(Mount mount) {
        this.mount = mount;
    }

    @Override
    public void mountMove() {
        mount.move();
    }

    public String getWeapon() {
        return weapon;
    }

    public Orc setWeapon(String weapon) {
        this.weapon = weapon; return this;
    }

    public int getColorCode() {
        return colorCode;
    }

    public Orc setColorCode(int colorCode) {
        this.colorCode = colorCode;return this;
    }

    public Mount getMount() {
        return mount;
    }
}




