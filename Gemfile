source "https://rubygems.org"
gem "fastlane"

gem 'net-scp','~>1.2.1'
gem 'net-ssh','~>4.2.0'

plugins_path = File.join(File.dirname(__FILE__), 'fastlane', 'Pluginfile')
eval_gemfile(plugins_path) if File.exist?(plugins_path)
