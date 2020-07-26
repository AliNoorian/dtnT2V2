package com.dotin.leavesystem.rest;

import com.dotin.leavesystem.dao.LeaveService;
import com.dotin.leavesystem.models.Leave;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class LeaveRestController {

    private final LeaveService leaveService;

    public LeaveRestController(LeaveService leaveService) {
        this.leaveService = leaveService;
    }

    @GetMapping("/leave")
    public List<Leave> findAll() {
        return leaveService.findAll();
    }

    @GetMapping("/leave/{leaveId}")
    public Leave getLeave(@PathVariable int leaveId) {

        Leave theLeave = leaveService.findById(leaveId);
        if (theLeave == null) {
            throw new RuntimeException("Leave id not found - " + leaveId);
        }
        return theLeave;
    }

    @PostMapping("/leave")
    public Leave addLeave(@RequestBody Leave theLeave) {

        theLeave.setLeaveId(0);
        leaveService.save(theLeave);
        return theLeave;

    }

    @PutMapping("/leave")
    public Leave updateLeave(@RequestBody Leave theLeave) {

        leaveService.save(theLeave);
        return theLeave;

    }

    @DeleteMapping("/leave/{leaveId}")
    public String deleteLeave(@PathVariable int leaveId) {

        Leave theLeave = leaveService.findById(leaveId);
        if (theLeave == null) {
            throw new RuntimeException("Leave id not found - " + leaveId);
        }
        leaveService.deleteById(leaveId);
        return "Successfully deleted leave id - " + leaveId;
    }


}
