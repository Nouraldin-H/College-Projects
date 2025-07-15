package sandbox;

import java.util.Scanner;
import java.util.prefs.Preferences;

public class DarkModeChecker {
	private String RegistryKeyPath = "Software\\Microsoft\\Windows\\CurrentVersion\\Themes\\Personalize";

	private String RegistryValueName = "AppsUseLightTheme";

	private static ApplicationTheme GetWindowsTheme()
	{
	    using var key = Registry.CurrentUser.OpenSubKey(RegistryKeyPath);
	    var registryValueObject = key?.GetValue(RegistryValueName);
	    if (registryValueObject == null)
	    {
	        return ApplicationTheme.Light;
	    }
	    var registryValue = (int)registryValueObject;

	    return registryValue > 0 ? ApplicationTheme.Light : ApplicationTheme.Dark;
	}
}
