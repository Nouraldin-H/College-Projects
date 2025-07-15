using System.Collections.Generic;
using Xunit;

namespace TestProject1
{
	public class RecordTests
	{
		[Fact]
		public void ReadCsv_FileExists_ReturnsRecords()
		{
			// Arrange
			string filePath = "../../../keystone-throughput-and-capacity.csv";
			// Act
			List<Record> records = Program.ReadCsv(filePath);
			// Assert
			Assert.NotEmpty(records);
		}

		[Fact]
		public void ReadCsv_FileNotFound_ThrowsFileNotFoundException()
		{
			// Arrange
			string filePath = "keystone-throughput-and-capacity.csv";
			// Act
			List<Record> records = Program.ReadCsv(filePath);
			// Assert
			Assert.Throws<FileNotFoundException>(() => Program.ReadCsv(filePath));
		}

		[Fact]
		public void ReadCsv_FileExists_ReturnsRecordsEmpty()
		{
			// Arrange
			string filePath = "../../../keystone-throughput-and-capacity.csv";
			// Act
			List<Record> records = Program.ReadCsv(filePath);
			// Assert
			Assert.Empty(records);
		}
	}
}