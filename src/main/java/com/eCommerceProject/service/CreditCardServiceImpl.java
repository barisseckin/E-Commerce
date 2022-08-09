package com.eCommerceProject.service;

import com.eCommerceProject.model.CreditCard;
import com.eCommerceProject.model.User;
import com.eCommerceProject.repository.CreditCardRepository;
import com.eCommerceProject.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CreditCardServiceImpl implements CreditCardService{

    private final CreditCardRepository creditCardRepository;

    private final UserService userService;

    @Override
    public List<CreditCard> getAll() {
        return creditCardRepository.findAll();
    }

    @Override
    public CreditCard add(CreditCard creditCard) {
        return creditCardRepository.save(creditCard);
    }

    @Override
    public List<CreditCard> getCreditCardByUserId(int id) {
        Optional<User> user = Optional.ofNullable(userService.getById(id));

        if (user.isPresent()) {
            CreditCard creditCard = user.get().getCreditCard();
            return List.of(creditCard);
        }
        return null;
    }

    @Override
    public CreditCard getBydId(int id) {
        Optional<CreditCard> creditCard = creditCardRepository.findById(id);
        return creditCard.orElse(null);
    }
}
