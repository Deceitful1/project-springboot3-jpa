package course.com.springboot3project.entities;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable
{
    private Long Id;
    private String Name;
    private String Email;
    private String phone;
    private String password;

    public User()
    {
    }

    public User(Long id, String name, String email, String phone, String password)
    {
        Id = id;
        Name = name;
        Email = email;
        this.phone = phone;
        this.password = password;
    }

    public Long getId()
    {
        return Id;
    }

    public void setId(Long id)
    {
        Id = id;
    }

    public String getName()
    {
        return Name;
    }

    public void setName(String name)
    {
        Name = name;
    }

    public String getEmail()
    {
        return Email;
    }

    public void setEmail(String email)
    {
        Email = email;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(Id, user.Id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(Id);
    }

}
