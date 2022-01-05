package Senseup.Minisense.Api.Builder;

import Senseup.Minisense.Api.DTOs.StreamDTO;
import Senseup.Minisense.Api.Model.DataStreamModel;
import Senseup.Minisense.Api.Model.SensorDeviceModel;

import java.util.ArrayList;
import java.util.List;

public class SensorDeviceBuilder {
    public long id;
    public String key;
    public String label;
    public String description;
    public List<StreamDTO> streams;

    public SensorDeviceBuilder(SensorDeviceModel sensor, List<DataStreamModel> dataStreams) {
        this.id = sensor.getId();
        this.key = sensor.getKey();
        this.label = sensor.getLabel();
        this.description = sensor.getDescription();
        this.streams = buildStreams(dataStreams);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<StreamDTO> getStreams() {
        return streams;
    }

    public void setStreams(List<StreamDTO> streams) {
        this.streams = streams;
    }

    public List<StreamDTO> buildStreams(List<DataStreamModel> dataStreams) {
        List<StreamDTO> streams = new ArrayList<StreamDTO>();

        for (DataStreamModel dataStream : dataStreams) {
            StreamDTO stream = new StreamDTO(dataStream.getId(), dataStream.getStreamKey(), dataStream.getLabel(), dataStream.getMeasurementUnit().getId(), dataStream.getSensor().getId(), 1);

            streams.add(stream);
        }

        return streams;
    }
}
