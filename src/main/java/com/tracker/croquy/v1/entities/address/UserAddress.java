package com.tracker.croquy.v1.entities.address;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tracker.croquy.v1.entities.User;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "ctex_user_addresses")
public class UserAddress extends AddressBaseEntity {
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}

