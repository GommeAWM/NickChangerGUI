����   4 i
  9 :
  9	  ;	  <
  = >
  ?	  @
  A
  B C
 D E F
  G
 H I J K
  ?
 L M
 H N O
  ?
 P Q	  R S T nickUI Lfrom/NickUI; nickResponse Lfrom/Listener/NickResponse; 
nickConfig Lfrom/utils/NickConfig; 
normalname Ljava/util/HashMap; 	Signature 9Ljava/util/HashMap<Lcn/nukkit/Player;Ljava/lang/String;>; <init> ()V Code LineNumberTable LocalVariableTable this onEnable 	onDisable registerAll simpleCommandMap $Lcn/nukkit/command/SimpleCommandMap; pluginManager  Lcn/nukkit/plugin/PluginManager; getNickResponse ()Lfrom/Listener/NickResponse; getNickConfig ()Lfrom/utils/NickConfig; 
SourceFile NickUI.java & ' java/util/HashMap " #   . ' from/utils/NickConfig & U   ! V ' W X §fEnable: §a§lNicknameUI Y Z [ §fDisable: §c§lNicknameUI \ ] ^ _ ` nick from/Command/NickCMD a b c d e from/Listener/NickResponse f g h   from/NickUI cn/nukkit/plugin/PluginBase (Lfrom/NickUI;)V createDefaultConfig 	getLogger !()Lcn/nukkit/plugin/PluginLogger; cn/nukkit/plugin/PluginLogger info (Ljava/lang/String;)V 	getServer ()Lcn/nukkit/Server; cn/nukkit/Server getCommandMap &()Lcn/nukkit/command/SimpleCommandMap; "cn/nukkit/command/SimpleCommandMap register 0(Ljava/lang/String;Lcn/nukkit/command/Command;)Z getPluginManager "()Lcn/nukkit/plugin/PluginManager; cn/nukkit/plugin/PluginManager registerEvents 6(Lcn/nukkit/event/Listener;Lcn/nukkit/plugin/Plugin;)V !      	          	   !     " #  $    %   & '  (   >     *� *� Y� � �    )   
       *        +     , '  (   a     #*� *� � Y*� � 	� 	� 
*� � �    )                "  *       # +     - '  (   8     
*� � �    )   
    ! 	 " *       
 +     . '  (   {     -*� � L+� Y*� � W*� � M,� Y*� *� �    )       %  &  (  ) , * *        - +     % / 0    1 2   3 4  (   /     *� �    )       - *        +     5 6  (   .     � 	�    )       1 *        +     7    8