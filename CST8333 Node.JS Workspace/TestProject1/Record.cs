namespace TestProject1
{

	/// <summary>
	/// Represents a record in the dataset.
	/// </summary>
	public class Record
	{
		public string DateColumn { get; set; }
		public string MonthColumn { get; set; }
		public string YearColumn { get; set; }
		public string CompanyColumn { get; set; }
		public string PipelineColumn { get; set; }
		public string KeyPointColumn { get; set; }
		public string LatitudeColumn { get; set; }
		public string LongitudeColumn { get; set; }
		public string FlowDirectionColumn { get; set; }
		public string TradeTypeColumn { get; set; }
		public string ProductColumn { get; set; }
		public string ThroughputColumn { get; set; }
		public string CommitedVolumesColumn { get; set; }
		public string UncommitedVolumesColumn { get; set; }
		public string NameplateCapacityColumn { get; set; }
		public string AvailableCapacityColumn { get; set; }
		public string VarianceReasonColumn { get; set; }


		/// <summary>
		/// Initializes a new instance of the <see cref="Record"/> class.
		/// </summary>
		public Record(string dateColumn, string monthColumn, string yearColumn, string companyColumn, string pipelineColumn, string keyPointColumn, string latitudeColumn, string longitudeColumn, string flowDirectionColumn, string tradeTypeColumn, string productColumn, string throughputColumn, string commitedVolumesColumn, string uncommitedVolumesColumn, string nameplateCapacityColumn, string availableCapacityColumn, string varianceReasonColumn)
		{
			DateColumn = dateColumn;
			MonthColumn = monthColumn;
			YearColumn = yearColumn;
			CompanyColumn = companyColumn;
			PipelineColumn = pipelineColumn;
			KeyPointColumn = keyPointColumn;
			LatitudeColumn = latitudeColumn;
			LongitudeColumn = longitudeColumn;
			FlowDirectionColumn = flowDirectionColumn;
			TradeTypeColumn = tradeTypeColumn;
			ProductColumn = productColumn;
			ThroughputColumn = throughputColumn;
			CommitedVolumesColumn = commitedVolumesColumn;
			UncommitedVolumesColumn = uncommitedVolumesColumn;
			NameplateCapacityColumn = nameplateCapacityColumn;
			AvailableCapacityColumn = availableCapacityColumn;
			VarianceReasonColumn = varianceReasonColumn;
		}
	}
}