package br.dcomp.ufs.softwaretest.thiago.credit;

public class Credit {

    private int LIMIT_PARCELS = 12;
    private double SALARY_FLOOR = 5000;

    public boolean grantCredit(int parcel, boolean reliable, double salary) {
        if (parcel > LIMIT_PARCELS)
            return false;
        else if (!reliable)
            return false;
        else if (salary < SALARY_FLOOR)
            return false;
        else
            return true;
    }

    public double defineCredit(int parcel, boolean reliable, double salary) {
        if (grantCredit(parcel, reliable, salary))
            return 20000;
        else
            return 0;
    }

}
