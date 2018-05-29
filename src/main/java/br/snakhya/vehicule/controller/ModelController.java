package br.snakhya.vehicule.controller;

import br.snakhya.vehicule.domain.Assembler;
import br.snakhya.vehicule.domain.Model;
import br.snakhya.vehicule.repositories.AssemblerRepository;
import br.snakhya.vehicule.repositories.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/models")
public class ModelController {


        @Autowired
        private ModelRepository modelRepository;

        @RequestMapping(value = "",
                method = RequestMethod.GET,
                produces = {"application/json", "application/xml"})

        @ResponseBody
        public List<Model> getAllModels() {
            return this.modelRepository.findAll();
        }


        @PostMapping("")
        public Model createAsembler( @RequestBody Model model) {
            return this.modelRepository.save(model) ;
        }

        @PutMapping("/{modelId}")
        public Model updateModel(@PathVariable Long modelId, @Valid @RequestBody Model model) throws  Exception{
            Model model1 =  this.modelRepository.findById(modelId).get() ;
            model1.setNameModel(model.getNameModel());
            this.modelRepository.save(model1);
            return model1;
        }

        @DeleteMapping("/{modelId}")
        public String deleteModel(@PathVariable(value = "modelId") Long id) {
            Model model = modelRepository.findById(id).get();
            String name = model.getNameModel();
            modelRepository.delete(model);
            return "the model "+name +" is deleted ";
        }
    }
