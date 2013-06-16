package fr.matleclaire.pasteit;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface PasteRepository extends MongoRepository<Paste, String> {

}
