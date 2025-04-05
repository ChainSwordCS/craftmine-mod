package com.example.mixin;

//import java.lang.String;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.Shadow;
import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;

import java.util.Optional;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.AssetInfo;

import net.minecraft.aprilfools.PlayerUnlock;
//import net.minecraft.aprilfools.PlayerUnlock.Builder;

@Mixin(PlayerUnlock.Builder.class)
public abstract class PlayerUnlockMixin {
	
	@Accessor("exclusiveKey")
	public abstract String getExclusiveKey();
	@Accessor("exclusiveKey")
	public abstract void setExclusiveKey(String exclusiveKey);
	
	
	
	//@Shadow
	//protected String exclusiveKey;
	
	//@Mixin(Builder.class)
	//public abstract static class BuilderMixin {
		@Inject(at = @At("TAIL"), method = "<init>")
		private void BuilderPost(String $$0, Optional<RegistryEntry<PlayerUnlock>> $$1, Optional<AssetInfo> $$2, CallbackInfo ci) {
			
			//PlayerUnlock.Builder thisObject = (PlayerUnlock.Builder)(Object)this;
			
			//if(thisObject.exclusiveKey.equals("")) {
			//if(localRef.get().exclusiveKey.equals("")) {
			if(getExclusiveKey().equals("")) {
				//thisObject.exclusiveKey.equals($$0);
				setExclusiveKey($$0);
			}
		}
		
		
	//}
}
/*
@Mixin(TargetClass.class)
public class MyMixin extends EveryThingThatTargetClassExtends implements EverythingThatTargetClassImplements {
  @Inject(method = "foo()V", at = @At("HEAD"))
  private void injected(CallbackInfo ci) {
    TargetClass thisObject = (TargetClass)(Object)this;
  }
}



@Inject(method = "foo()V", at = @At("TAIL"))
private void injected(CallbackInfo ci) {
  doSomething4();
}
*/
