package com.mickey42302.devonly.mixin;

import net.minecraft.SharedConstants;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({SharedConstants.class})
public abstract class SharedConstantsMixin {
  @Final
  @Shadow
  @Mutable
  public static boolean USE_DEVONLY;

  @Inject(method = {"<clinit>"}, at = {@At("TAIL")})
  private static void setUseDevonly$clinit(CallbackInfo ci) {
    USE_DEVONLY = true;
  }
}
