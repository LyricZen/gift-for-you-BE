package com.giftforyoube.donation.repository;

import com.giftforyoube.donation.entity.Donation;
import com.giftforyoube.user.entity.User;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DonationRepository extends JpaRepository<Donation, Long> {

    List<Donation> findByFundingIdOrderByDonationRankingDesc(Long fundingId);

    List<Donation> findByFundingId(Long fundingId);

    @Query("SELECT SUM(d.donationAmount) FROM Donation d WHERE d.funding.id = :fundingId")
    int getTotalDonationAmountByFundingId(Long fundingId);

    @Query("SELECT SUM(d.donationAmount) FROM Donation d")
    Long sumDonationAmounts();


}