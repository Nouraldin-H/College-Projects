/**
 * This class represents a record.
 * @author {Nouraldin Hassan}
 */
class Record {
    /**
     * Creates a record by having columns displayed.
     * @param {string} date - The date.
     * @param {string} month - The month.
     * @param {string} year - The year.
     * @param {string} company - The company.
     * @param {string} pipeline - The pipeline.
     * @param {string} keyPoint - The key point.
     * @param {string} latitude - The latitude.
     * @param {string} longitude - The longitude.
     * @param {string} flowDirection - The flow direction.
     * @param {string} tradeType - The trade type.
     * @param {string} product - The product.
     * @param {string} throughput - The throughput.
     * @param {string} committedVolumes - The committed volumes.
     * @param {string} uncommittedVolumes - The uncommitted volumes.
     * @param {string} nameplateCapacity - The nameplate capacity.
     * @param {string} availableCapacity - The available capacity.
     * @param {string} varianceReason - The variance reason.
     */
    constructor(date, month, year, company, pipeline, keyPoint, latitude, longitude, flowDirection, tradeType, product, throughput, committedVolumes, uncommittedVolumes, nameplateCapacity, availableCapacity, varianceReason) {
        this._date = date;
        this._month = month;
        this._year = year;
        this._company = company;
        this._pipeline = pipeline;
        this._keyPoint = keyPoint;
        this._latitude = latitude;
        this._longitude = longitude;
        this._flowDirection = flowDirection;
        this._tradeType = tradeType;
        this._product = product;
        this._throughput = throughput;
        this._committedVolumes = committedVolumes;
        this._uncommittedVolumes = uncommittedVolumes;
        this._nameplateCapacity = nameplateCapacity;
        this._availableCapacity = availableCapacity;
        this._varianceReason = varianceReason;
    }

    get date() { return this._date; }
    set date(value) { this._date = value; }

    get month() { return this._month; }
    set month(value) { this._month = value; }

    get year() { return this._year; }
    set year(value) { this._year = value; }

    get company() { return this._company; }
    set company(value) { this._company = value; }

    get pipeline() { return this._pipeline; }
    set pipeline(value) { this._pipeline = value; }

    get keyPoint() { return this._keyPoint; }
    set keyPoint(value) { this._keyPoint = value; }

    get latitude() { return this._latitude; }
    set latitude(value) { this._latitude = value; }

    get longitude() { return this._longitude; }
    set longitude(value) { this._longitude = value; }

    get flowDirection() { return this._flowDirection; }
    set flowDirection(value) { this._flowDirection = value; }

    get tradeType() { return this._tradeType; }
    set tradeType(value) { this._tradeType = value; }

    get product() { return this._product; }
    set product(value) { this._product = value; }

    get throughput() { return this._throughput; }
    set throughput(value) { this._throughput = value; }

    get committedVolumes() { return this._committedVolumes; }
    set committedVolumes(value) { this._committedVolumes = value; }

    get uncommittedVolumes() { return this._uncommittedVolumes; }
    set uncommittedVolumes(value) { this._uncommittedVolumes = value; }

    get nameplateCapacity() { return this._nameplateCapacity; }
    set nameplateCapacity(value) { this._nameplateCapacity = value; }

    get availableCapacity() { return this._availableCapacity; }
    set availableCapacity(value) { this._availableCapacity = value; }

    get varianceReason() { return this._varianceReason; }
    set varianceReason(value) { this._varianceReason = value; }
}

module.exports = Record;