package com.example.foodbook.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class MainData implements Parcelable {

    //TODO: CHANGE ALL PARAMETERS TO USER PARMETER

    @SerializedName("flag")
    public String flag;
    @SerializedName("name")
    public String name;
    @SerializedName("nativeName")
    public String nativeName;
    @SerializedName("alpha3Code")
    public String code;
    @SerializedName("borders")
    private ArrayList<String> borders = new ArrayList<>();
    public MainData() {
    }

    protected MainData(Parcel in) {
        flag = in.readString();
        name = in.readString();
        nativeName = in.readString();
        code = in.readString();
        borders = in.createStringArrayList();
    }

    public static final Creator<MainData> CREATOR = new Creator<MainData>() {
        @Override
        public MainData createFromParcel(Parcel in) {
            return new MainData(in);
        }

        @Override
        public MainData[] newArray(int size) {
            return new MainData[size];
        }
    };

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() { return code; }

    public void setCode(String code) { this.code = code; }

    public String getNativeName() {
        return nativeName;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    public ArrayList<String> getBorders() {
        return borders;
    }

    public void setBorders(ArrayList<String> borders) {
        this.borders = borders;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(flag);
        dest.writeString(name);
        dest.writeString(nativeName);
        dest.writeString(code);
        dest.writeStringList(borders);
    }

}
