module Fastlane

  module Actions

    module SharedValues
      ANDROID_MONKEY_CUSTOM_VALUE = :ANDROID_MONKEY_CUSTOM_VALUE
    end

  #adb shell monkey -p com.xiao.demo --ignore-security-exceptions --ignore-crashes --ignore-timeouts --monitor-native-crashes --throttle  300 --pct-touch 94 --pct-motion 6 -s 1000 -v -v -v 6000
     class AndroidMonkeyAction < Action
       def self.run(params)
           package_name = params[:package_name]
           count = params[:count]
           throttle = params[:throttle]
           seed = params[:seed]
        
           command = ['adb shell monkey']
           command << " -p #{package_name} "
           command << " --ignore-security-exceptions "
           command << " --ignore-crashes "
           command << " --ignore-timeouts "
           command << " --monitor-native-crashes "
           command << " --throttle  #{throttle} "
           command << " --pct-touch 94 "
           command << " --pct-motion 6 "
           command << " -s #{seed} -v -v -v #{count} "
           Action.sh command.join(' ')
       end
       
       def self.available_options
          [
            FastlaneCore::Continuation.new(key: :package_name,description:"Android App Package Name"),
            FastlaneCore::Continuation.new(key: :count,description:"event count"),
            FastlaneCore::Continuation.new(key: :throttle,description:"throttle"),
            FastlaneCore::Continuation.new(key: :seed,description:"seed count")
          ]
       end 
      
     end
  end
end            

