package lk.lmuthumal.demo.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Company")
public class Company{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "company_id")
    private int companyId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Lob @Basic(fetch = FetchType.LAZY)
    @Column(name = "logo",length=1000000)
    private byte[] logo;

    @Column(name = "website")
    private String website;

    public Company() {
    }

    public Company(String name, String email, byte[] logo, String website) {
        this.name = name;
        this.email = email;
        this.logo = logo;
        this.setWebsite(website);
    }

    public Company(int companyId, String name, String email, byte[] logo, String website) {
        this.setCompanyId(companyId);
        this.setName(name);
        this.setEmail(email);
        this.setLogo(logo);
        this.setWebsite(website);
    }

    public Company(int companyId, String name, String email, String website) {
        this.companyId=companyId;
        this.name = name;
        this.email = email;
        this.website = website;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }


    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
