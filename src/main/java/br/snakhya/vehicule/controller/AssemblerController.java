package br.snakhya.vehicule.controller;

import br.snakhya.vehicule.domain.Assembler;
import br.snakhya.vehicule.repositories.AssemblerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping(value = "/assemblers")
public class AssemblerController {


        @Autowired
        private AssemblerRepository assemblerRepository;

        @RequestMapping(value = "",
                method = RequestMethod.GET,
                produces = {"application/json", "application/xml"})

        @ResponseBody
        public List<Assembler> getAllAssemblers() {
            return this.assemblerRepository.findAll();
        }


        @PostMapping("")
        public Assembler createAsembler( @RequestBody Assembler assembler) {
            return this.assemblerRepository.save(assembler) ;
        }

        @PutMapping("/{assemblerId}")
        public Assembler updateAssembler(@PathVariable Long assemblerId, @Valid @RequestBody Assembler assembler) throws  Exception{
            Assembler assembler1 =  this.assemblerRepository.findById(assemblerId).get() ;
            assembler1.setAssemblerName(assembler.getAssemblerName());
            this.assemblerRepository.save(assembler1);
            return assembler1;
        }

        @DeleteMapping("/{assemblerId}")
        public String deleteAssembler(@PathVariable(value = "assemblerId") Long id) {
            Assembler assembler = assemblerRepository.findById(id).get();
            String name = assembler.getAssemblerName();
            assemblerRepository.delete(assembler);
            return "the assembler "+name +" is deleted ";
        }
    }

