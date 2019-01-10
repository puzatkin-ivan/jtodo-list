package com.jtodo.command;
import com.jtodo.command.exception.*;
import com.jtodo.model.deal.*;
import com.jtodo.model.deal.IDeal;
import com.jtodo.model.list.*;
import com.jtodo.model.storage.*;

import java.util.List;

public class CreateCommand implements ICommand {
    private IStorage storage;

    public CreateCommand(IStorage storage) {
        this.storage = storage;
    }

    @Override
    public void execute(String[] args) throws CommandException {
        if (args[1].equals("list") && args.length == 3) {
            IList list = new CList();
            list.setName(args[2]);
            this.storage.addList(list);
        } else if (args[1].equals("deal") && args.length == 4 && this.storage.getList().size() > Integer.parseInt(args[2])) {
            IDeal deal = new Deal();
            deal.setName(args[3]);
            List<IList> lists = this.storage.getList();
            IList list = lists.get(Integer.parseInt(args[2]));
            list.addDeal(deal);
        }
    }
}
