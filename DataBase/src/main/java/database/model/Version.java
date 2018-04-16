package database.model;

import lombok.Data;
import database.model.descriptors.VersionDescription;

import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@MappedSuperclass
public class Version {

    @NotNull
    public String version;

    @OneToOne
    public VersionDescription versionDescription;

    public LocalDate date;

    public Version(){
        version = "1";
        versionDescription = new VersionDescription();
        setDate();
    }

    public Version(String version, String description){
        this.version = version;
        versionDescription = new VersionDescription(description);
        setDate();
    }

    private void setDate(){
        date = LocalDate.now();
    }
}