package com.example.kaiburr;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ServersController {

    @Autowired
    private ServerRepository repo;
    @CrossOrigin("http://localhost:4200")
    @GetMapping("/api")
    @ApiOperation(value = "Finds Servers by id and filters Servers by name, if no parameters passed gets list of all servers ", notes = "Provide either id or name to find or filter servers", response = Server.class)
    public ResponseEntity<?> getServers(@ApiParam(value="id value is id of the server to retrieve specific server") @RequestParam(required = false)String id,@ApiParam(value="name value is name of the server, to retrieve similar servers")  @RequestParam(required = false)String name){
        if(name!=null){
            Server server = new Server();
            server.setName(name);
            Example<Server> serverEx = Example.of(server);
            List<Server> servers = this.repo.findAll(serverEx);
            if(servers.isEmpty()){throw new ServerNotFoundException(name);}
            else
                return ResponseEntity.ok(servers);
        }

        if(id==null)
            return ResponseEntity.ok(this.repo.findAll());
        else{
            return ResponseEntity.ok(this.repo.findById(id));
        }
    }
    @CrossOrigin("http://localhost:4200")
    @PostMapping("/api")
    @ApiOperation(value = "Post server as json object")
    public ResponseEntity<?> addServer(@RequestBody Server server)
    {
        Server save = this.repo.save(server);
        return ResponseEntity.ok(save);
    }
    @CrossOrigin("http://localhost:4200")
    @DeleteMapping("/api")
    @ApiOperation(value = "Delete server by id")
    public void DeleteServer(@ApiParam(value="id value is id of the server to delete specific server",required = true)@RequestParam(required = true) String id){
        this.repo.deleteById(id);
    }




}
