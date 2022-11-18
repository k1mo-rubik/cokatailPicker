package ru.cocktails.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "customers")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Customer {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nickname", nullable = false, length = 100)
    private String nickname;

    @ManyToMany
    @JoinTable(name = "customers_cocktails",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "cocktail_id"))
    private Set<Cocktail> cocktails = new LinkedHashSet<>();

}