namespace TestProject1
{

	/// <summary>
	/// The main program class.
	/// </summary>
	public class Program
	{
		/// <summary>
		/// The main entry point of the program.
		/// </summary>
		/// <param name="args">The command-line arguments.</param>
		public static void Main(string[] args)
		{
			string filePath = "../../../keystone-throughput-and-capacity.csv";
			List<Record> records = ReadCsv(filePath);
			DisplayRecords(records);
			Console.WriteLine("Nouraldin Hassan");
			Console.ReadKey();
		}

		/// <summary>
		/// Reads the CSV file and returns a list of records.
		/// </summary>
		/// <param name="filePath">The path to the CSV file.</param>
		/// <returns>A list of records.</returns>
		public static List<Record> ReadCsv(string filePath)
		{
			List<Record> records = new List<Record>();
			try
			{
				using (var reader = new StreamReader(filePath))
				{
					string line;
					bool isFirstLine = true;
					while ((line = reader.ReadLine()) != null)
					{
						if (isFirstLine)
						{
							isFirstLine = false;
							continue; // Skip header row
						}
						var values = line.Split(',');
						var record = new Record(values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7], values[8], values[9], values[10], values[11], values[12], values[13], values[14], values[15], values[16]);
						records.Add(record);
					}
				}
			}
			catch (FileNotFoundException)
			{
				Console.WriteLine("File not found.");
			}
			return records;
		}

		/// <summary>
		/// Displays the records on the console.
		/// </summary>
		/// <param name="records">The list of records.</param>
		public static void DisplayRecords(List<Record> records)
		{
			if (records.Count == 0)
			{
				Console.WriteLine("No records found.");
			}
			else
			{
				// Print header
				Console.WriteLine("{0,-12} {1,-10} {2,-10} {3,-40} {4,-20} {5,-50} {6,-30} {7,-30} {8,-30} {9,-30} {10,-30} {11,-30} {12,-40} {13,-40} {14,-40} {15,-40} {16,-40}",
					"Date", "Month", "Year", "Company", "Pipeline", "Key Point", "Latitude", "Longitude", "Flow Direction", "Trade Type", "Product", "Throughput", "Committed Volumes", "Uncommitted Volumes", "Nameplate Capacity", "Available Capacity", "Variance Reason");

				// Print records
				foreach (var record in records)
				{
					Console.WriteLine("{0,-12} {1,-10} {2,-10} {3,-40} {4,-20} {5,-50} {6,-10} {7,-10} {8,-15} {9,-15} {10,-10} {11,-15} {12,-20} {13,-20} {14,-20} {15,-20} {16,-20}",
						record.DateColumn, record.MonthColumn, record.YearColumn, record.CompanyColumn, record.PipelineColumn, record.KeyPointColumn, record.LatitudeColumn, record.LongitudeColumn, record.FlowDirectionColumn, record.TradeTypeColumn, record.ProductColumn, record.ThroughputColumn, record.CommitedVolumesColumn, record.UncommitedVolumesColumn, record.NameplateCapacityColumn, record.AvailableCapacityColumn, record.VarianceReasonColumn);
				}
			}
		}
	}
}