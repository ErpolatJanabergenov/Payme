package model;

import lombok.*;

import java.util.Date;
import java.util.UUID;
@Getter
@Setter

public abstract class BaseModel {

    {
        this.id = UUID.randomUUID();
        this.createdDate =  new Date();
        this.updatedDate =  new Date();
    }
    protected UUID id;
    protected Date createdDate;
    protected Date updatedDate;

}
