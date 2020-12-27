package com.johnpike.javaBeltExam3.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.johnpike.javaBeltExam3.models.Network;
import com.johnpike.javaBeltExam3.models.Review;
import com.johnpike.javaBeltExam3.models.TVShow;
import com.johnpike.javaBeltExam3.repositories.NetworkRepository;
import com.johnpike.javaBeltExam3.repositories.ReviewRepository;
import com.johnpike.javaBeltExam3.repositories.TVShowRepository;

@Service
public class ShowService {

	private static TVShowRepository showRepo;
	private static NetworkRepository networkRepo;
	private static ReviewRepository revRepo;

	public ShowService(TVShowRepository showRepo, NetworkRepository networkRepo, ReviewRepository revRepo) {
		this.showRepo = showRepo;
		this.networkRepo = networkRepo;
		this.revRepo = revRepo;
	}

	public TVShow create(TVShow newShow) {
		return showRepo.save(newShow);
	}

	public Network create(Network newNetwork) {
		return networkRepo.save(newNetwork);
	}

//make sure user has NOT already reviewed that game
	public Review create(Review newReview) {
		List<Review> matchingReviews = revRepo.matchingReviews(newReview.getUser().getId(),
				newReview.getTVShow().getId());
		if (matchingReviews.size() > 0) {
			return null;
		}
		newReview.setId(null);
		return revRepo.save(newReview);
	}

	public List<Network> getNetwork() {
		return (List<Network>) networkRepo.findAll();
	}

	public List<TVShow> getTVShow() {
		return (List<TVShow>) showRepo.findAll();
	}

	public Network getNetwork(Long id) {
		Optional<Network> network = networkRepo.findById(id);
		return network.isPresent() ? network.get() : null;
	}

	public TVShow getTVShow(Long id) {
		Optional<TVShow> show = showRepo.findById(id);
		return show.isPresent() ? show.get() : null;
	}

	public TVShow saveGame(TVShow show) {
		return showRepo.save(show);
	}

	public Network createOrRetrieve(String networkName) {
		Optional<Network> mightExist = networkRepo.findNetworkByName(networkName);
		if (mightExist.isPresent()) {
			return mightExist.get();
		} else {
			return networkRepo.save(new Network(networkName));
		}
	}

	public TVShow createShowWithNetworks(TVShow newShowPlus) {
		return showRepo.save(newShowPlus);
	}

	// this is the method finding games of a certain genre
	public List<TVShow> showsInNetworks(String networks) {
		Optional<Network> n = networkRepo.findNetworkByName(networks);
		return n.isPresent() ? n.get().getTVShow() : new ArrayList<TVShow>();
	}

}