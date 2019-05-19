package com.laba.project.virtuozapp;

public class Guids {


    public String[] guidsarr=new String[101];


    public String[] wakemeupguid= new String[10];
    public String[] blackorwhiteguid= new String[10];
    public String[] sendmeanangelguid= new String[10];
    public String[] vihodanetguid= new String[10];
    public String[] etovseguid= new String[10];
    public String[] dadayaguid = new String[10];

    public void processing()
    {

        if (guidsarr[0]!= null)
        wakemeupguid=guidsarr[0].split(";");
        if (guidsarr[1]!= null)
        blackorwhiteguid=guidsarr[1].split(";");
        if (guidsarr[2]!= null)
        sendmeanangelguid=guidsarr[2].split(";");
        if (guidsarr[3]!= null)
        vihodanetguid=guidsarr[3].split(";");
        if (guidsarr[4]!= null)
        etovseguid=guidsarr[4].split(";");
        if (guidsarr[5]!= null)
            dadayaguid=guidsarr[5].split(";");





    }

}
