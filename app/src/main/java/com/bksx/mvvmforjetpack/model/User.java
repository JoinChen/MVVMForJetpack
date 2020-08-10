package com.bksx.mvvmforjetpack.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.*;

/**
 * @Author JoneChen
 * @Date 2020\8\6 0006-9:57
 */
@Entity(tableName = "user")
public class User {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id",typeAffinity = ColumnInfo.INTEGER)
    @SerializedName("id")
    public int id;

    @ColumnInfo(name = "name",typeAffinity = ColumnInfo.TEXT)
    @SerializedName("name")
    public String name;

    @ColumnInfo(name = "avatar",typeAffinity = ColumnInfo.TEXT)
    @SerializedName("avatar_url")
    public String avatar;

    @ColumnInfo(name = "followers",typeAffinity = ColumnInfo.TEXT)
    @SerializedName("followers")
    public String followers;

    @ColumnInfo(name = "following",typeAffinity = ColumnInfo.TEXT)
    @SerializedName("following")
    public String following;

    @ColumnInfo(name = "blog",typeAffinity = ColumnInfo.TEXT)
    @SerializedName("blog")
    public String blog;

    @ColumnInfo(name = "company",typeAffinity = ColumnInfo.TEXT)
    @SerializedName("company")
    public String company;

    @ColumnInfo(name = "bio",typeAffinity = ColumnInfo.TEXT)
    @SerializedName("bio")
    public String bio;

    public User(int id, String name, String avatar, String followers, String following, String blog, String company, String bio) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.followers = followers;
        this.following = following;
        this.blog = blog;
        this.company = company;
        this.bio = bio;
    }
}
