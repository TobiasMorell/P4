package com.P4.proxy;

import com.P4.init.ObsidiCodeBlocks;
import com.P4.init.ObsidiCodeItems;

public class ClientProxy extends CommonProxy {

    @Override
    public void registerRenders()
    {
        ObsidiCodeItems.registerRenders();
        ObsidiCodeBlocks.registerRenders();
    }
}