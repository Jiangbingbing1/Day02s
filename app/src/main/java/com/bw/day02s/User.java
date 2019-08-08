package com.bw.day02s;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class User {

    @Id(autoincrement = true)
    public Long id;
    public String imageUrl;
    public String jumpUrl;
    public int rank;
    public String title;
    @Generated(hash = 1436741924)
    public User(Long id, String imageUrl, String jumpUrl, int rank, String title) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.jumpUrl = jumpUrl;
        this.rank = rank;
        this.title = title;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getImageUrl() {
        return this.imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getJumpUrl() {
        return this.jumpUrl;
    }
    public void setJumpUrl(String jumpUrl) {
        this.jumpUrl = jumpUrl;
    }
    public int getRank() {
        return this.rank;
    }
    public void setRank(int rank) {
        this.rank = rank;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

}
